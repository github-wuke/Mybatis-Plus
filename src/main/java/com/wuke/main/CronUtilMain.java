package com.wuke.main;
/*
  入门级小工具：Cron表达式转中文描述。
  介绍：对于程序猿/媛来说，读懂这么简单的cron表达式简直是小菜一碟，但对于业务端的同学来说可真是捉摸不透。本工具类旨在让普通人也能理解cron表达式
*/
public class CronUtilMain {

    public static void main(String []args) {
        System.out.println(convertCronExpToChineseText("03 3 3 * ?"));
    }

    /*
    方法描述：转换cron表达式为中文文本
    参数类型：String
    参数简介：cron表达式

    注释屁话：最好的代码是不用注释的，代码本身就是注释
    */
    public static String convertCronExpToChineseText(String cronExp) {
        if (cronExp == null || cronExp.length() < 1) {
            return "cron表达式为空";
        }

        String[] tempCrons = cronExp.split(" ");
        StringBuffer resultInfo = new StringBuffer();
        if (tempCrons.length == 6) {
            //解析月
            if (!tempCrons[4].equals("*") && !tempCrons[4].equals("?")) {
                if (tempCrons[4].contains("/")) {
                    resultInfo.append("从").append(tempCrons[4].split("/")[0]).append("号开始").append(",每").append
                            (tempCrons[4].split("/")[1]).append("月");
                } else {
                    resultInfo.append("每年").append(tempCrons[4]).append("月");
                }
            }

            //解析周
            if (!tempCrons[5].equals("*") && !tempCrons[5].equals("?")) {
                if (tempCrons[5].contains(",")) {
                    resultInfo.append("每周的第").append(tempCrons[5]).append("天");
                } else {
                    resultInfo.append("每周");
                    char[] tmpArray = tempCrons[5].toCharArray();
                    for (char tmp : tmpArray) {
                        switch (tmp) {
                            case '1':
                                resultInfo.append("日");
                                break;
                            case '2':
                                resultInfo.append("一");
                                break;
                            case '3':
                                resultInfo.append("二");
                                break;
                            case '4':
                                resultInfo.append("三");
                                break;
                            case '5':
                                resultInfo.append("四");
                                break;
                            case '6':
                                resultInfo.append("五");
                                break;
                            case '7':
                                resultInfo.append("六");
                                break;
                            default:
                                resultInfo.append(tmp);
                                break;
                        }
                    }
                }
            }

            //解析日
            if (!tempCrons[3].equals("?")) {
                if (resultInfo.toString().contains("一") && resultInfo.toString().contains("二") && resultInfo.toString()
                        .contains("三")
                        && resultInfo.toString().contains("四") && resultInfo.toString().contains("五") && resultInfo.toString()
                        .contains("六")
                        && resultInfo.toString().contains("日")) {
                }

                if (!tempCrons[3].equals("*")) {
                    if (tempCrons[3].contains("/")) {
                        resultInfo.append("每周从第").append(tempCrons[3].split("/")[0]).append("天开始").append(",每").append
                                (tempCrons[3].split("/")[1]).append("天");
                    } else {
                        resultInfo.append("每月第").append(tempCrons[3]).append("天");
                    }
                }
            }

            //解析时
            if (!tempCrons[2].equals("*")) {
                if (tempCrons[2].contains("/")) {
                    resultInfo.append("从").append(tempCrons[2].split("/")[0]).append("点开始").append(",每").append
                            (tempCrons[2].split("/")[1]).append("小时");
                } else {
                    if (!(resultInfo.toString().length() > 0)) {
                        resultInfo.append("每天").append(tempCrons[2]).append("点");
                    }
                }
            }

            //解析分
            if (!tempCrons[1].equals("*")) {
                if (tempCrons[1].contains("/")) {
                    resultInfo.append("从第").append(tempCrons[1].split("/")[0]).append("分开始").append(",每").append
                            (tempCrons[1].split("/")[1]).append("分");
                } else if (tempCrons[1].equals("0")) {

                } else {
                    resultInfo.append(tempCrons[1]).append("分");
                }
            }
            if (resultInfo.toString().length() > 0) {
                resultInfo.append("执行一次");
            } else {
                resultInfo.append("表达式中文转换异常");
            }
        }
        return resultInfo.toString();
    }
}