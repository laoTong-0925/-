package com.analysishtml.demo11.analysisHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test {

    public void test() throws IOException {
        Document document = Jsoup.connect("http://www.csrc.gov.cn/pub/zjhpublic/G00306202/201712/t20171229_330048.htm?keywords=").get();
        Elements elements = document.getElementsByTag("td");
        for (Element e :
                elements) {
            String text = e.text();
            System.out.println(text);
            System.out.println();
        }
        Element elementById = document.getElementById("TRS_AUTOADD_1514549380640");
        Element child = elementById.child(1);
        Elements ps = elementById.getElementsByTag("p");
        System.out.println("=============");
        for (Element p :
                ps) {
            String text = p.text();
            System.out.println(text);
            System.out.println();
        }
        System.out.println(child.text());
//        System.out.println(document.title());
    }

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
