package com.analysishtml.demo11.service;

import com.analysishtml.demo11.mapper.ContentMapper;
import com.analysishtml.demo11.mapper.InfoMapper;
import com.analysishtml.demo11.mapper.StaffMapper;
import com.analysishtml.demo11.model.Content;
import com.analysishtml.demo11.model.Info;
import com.analysishtml.demo11.model.Staff;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnaHtml {

    @Autowired
    InfoMapper infoMapper;
    @Autowired
    ContentMapper contentMapper;
    @Autowired
    StaffMapper staffMapper;

    private static String URL = "http://www.csrc.gov.cn/pub/zjhpublic/G00306202/201712/t20171229_330048.htm?keywords=";
    private static Integer OUT3 = 3, OUT7 = 7;
    private static String ID = "TRS_AUTOADD_1514549380640";

    public boolean getInfo() throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements tdElements = document.getElementsByTag("td");
        Element tde;
        Info info = new Info();
        Content content = new Content();
        Staff staff = new Staff();
        int t = 0;
        for (int i = 1; i < tdElements.size(); i++) {
            if (i == 10)
                break;
            tde = tdElements.get(i);
            if (i == OUT3 || i == OUT7)
                continue;
            String text = tde.text();
            System.out.println(text);
            set(info, t, changeInfo(text));
            t++;
        }
        infoMapper.insert(info);
        Element elementById = document.getElementById(ID);
        Elements ps = elementById.getElementsByTag("p");
        int i = 0;
        StringBuilder auditor = new StringBuilder();
        StringBuilder auCompany = new StringBuilder();
        for (Element p : ps) {
            if (i == 2 || i == 3 || i == 7 || i == 8 || i == 12 || i == 13) {
                String text = p.text();
                System.out.println(text);
                auditor.append(text.trim() + "\n");
            }
            if (i != 0 && i % 5 == 0) {
                String text = p.text();
                System.out.println(text);
                auCompany.append(text.trim());
            }
            i++;
        }
        content.setTitle(info.getDesignation());
        content.setInfoId(info.getId());
        contentMapper.insert(content);
        staff.setAuditor(auditor.toString());
        staff.setContentId(content.getId());
        staff.setAuCompany(auCompany.toString());
        staffMapper.insert(staff);
        infoMapper.updateById(content.getId(), info.getId());
        contentMapper.updateById(staff.getId(), content.getId());
//        System.out.println(auditor.toString());
//        System.out.println(auCompany.toString());
        return false;
    }

    public static void main(String[] args) {
        AnaHtml anaHtml = new AnaHtml();
        try {
            anaHtml.getInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void set(Info info, int i, String v) {
        switch (i) {
            case 0:
                info.setInde(v);
                break;
            case 1:
                info.setAnalogy(v);
                break;
            case 2:
                info.setPromulgator(v);
                break;
            case 3:
                info.setPromTime(v);
                break;
            case 4:
                info.setDesignation(v);
                break;
            case 5:
                info.setSymbol(v);
                break;
            case 6:
                info.setHeading(v);
                break;
            default:
                break;
        }


    }

    private String changeInfo(String str) {
        if ("".equals(str))
            return str;
        return str.substring(str.indexOf(":") + 1);
    }

}
