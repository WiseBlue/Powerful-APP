package com.example.admin.bigdata.Knowledge;

/**
 * Created by admin on 2017/8/3.
 */

public class RegexTest {
    /**
     * 普通匹配
     * content为内容，pattern为正则表达式
     * Pattern.matches返回布尔值是否存在该匹配字符串
     */
        /*String content="I am noob from runoob.com.";
        String pattern=".*runoob.*";
        boolean isMatch= Pattern.matches(pattern,content);
        textView.setText("字符串中是否包含了'runoob'子字符串？"+isMatch);*/

    /**
     * 捕获组
     * matcher为内容对象
     * pattern为正则表达式对象
     * m.group(0)匹配整个pattern
     * m.group(1，2，3)依次匹配第1，2，3个括号，匹配到的字符串不计入下一次匹配内容
     */
        /*String line="This order was places for QT3000! OK?";
        String pattern="(\\D*)(\\d+)(.*)";
        //创建pattern对象
        Pattern r=Pattern.compile(pattern);
        //创建matcher对象
        Matcher m=r.matcher(line);
        StringBuilder sb=new StringBuilder();
        if (m.find()){
            sb.append("Found value:"+m.group(0)+"\n");
            sb.append("Found value:"+m.group(1)+"\n");
            sb.append("Found value:"+m.group(2)+"\n");
            sb.append("Found value:"+m.group(3)+"\n");
        }else {
            sb.append("NO MATCH");
        }
        textView.setText(sb.toString());*/

    /**
     * Matcher.start()返回匹配到的字符串的初始索引
     * Matcher.end()返回匹配到的字符串的结束索引+1
     */
        /*String REFEX="\\bcat\\b";
        String INPUT="cat cat cat cattie cat";
        Pattern p=Pattern.compile(REFEX);
        Matcher m=p.matcher(INPUT);
        StringBuilder sb=new StringBuilder();
        int count=0;
        while(m.find()){
            count++;
            sb.append("Match number "+count+"\n");
            sb.append("start():"+m.start()+"\n");
            sb.append("end():"+m.end()+"\n");
        }
        textView.setText(sb.toString());*/

    /**
     *Matcher.matches()要求整句都匹配
     *Matcher.lookingAt()不要求整句匹配，但要求从开头匹配
     */
        /*String REGEX="foo";
        String INPUT1="fooooooooooo";
        String INPUT2="oooofooooooo";
        Pattern p=Pattern.compile(REGEX);
        Matcher matcher1=p.matcher(INPUT1);
        Matcher matcher2=p.matcher(INPUT2);
        StringBuilder sb=new StringBuilder();
        sb.append("Current REGEX is:"+REGEX+"\n");
        sb.append("Current INPUT1 is"+INPUT1+"\n");
        sb.append("Current INPUT2 is"+INPUT2+"\n");
        sb.append("lookingAt():"+matcher1.lookingAt()+"\n");
        sb.append("matches()"+matcher1.matches()+"\n");
        sb.append("lookingAt():"+matcher2.lookingAt()+"\n");
        textView.setText(sb.toString());*/

    /**
     *Matcher.replaceFirst()替换首次匹配
     * Matcher.replaceAll()替换所有匹配
     */
        /*String REGEX="dog";
        String INPUT="The dog says meow. All dogs say meow.";
        String REPLACE="cat";
        Pattern p=Pattern.compile(REGEX);
        Matcher matcher=p.matcher(INPUT);
        INPUT= matcher.replaceAll(REPLACE);
        textView.setText(INPUT);*/

    /**
     * Matcher.appendReplacement最后一次匹配之前的加进去
     * Matcher.appendTail匹配之后剩余的部分加进去
     */
        /*String REGEX="a*b";
        String INPUT="aabfooaabfooabfoob";
        String REPLACE="-";
        Pattern p=Pattern.compile(REGEX);
        Matcher m=p.matcher(INPUT);
        StringBuffer sb=new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        textView.setText(sb.toString());*/
}
