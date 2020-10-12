#!/bin/bash
#给定一个文本文件 file.txt，请只打印这个文件中的第十行。
#
#示例:
#
#假设 file.txt 有如下内容：
#
#Line 1
#Line 2
#Line 3
#Line 4
#Line 5
#Line 6
#Line 7
#Line 8
#Line 9
#Line 10
#
#你的脚本应当显示第十行：
#
#Line 10
#
#说明:
#1. 如果文件少于十行，你应当输出什么？
#2. 至少有三种不同的解法，请尝试尽可能多的方法来解题。
# Read from the file file.txt and output the tenth line to stdout.

#first method
grep -n "" file.txt | grep -w '10' | cut -d: -f2

#second method
sed -n '10p' file.txt

#third method
awk 'if(NR == 10){print $0}' file.txt

#如果文件少于十行
#首先获取对文件的行数进行判断
file_row_num=$(cat file.txt | wc -l)
echo $file_row_num
# shellcheck disable=SC1020
if [ $file_row_num -lt 10 ];then
  echo "The number of row is less than 10"
else
  awk 'if(NR == 10){print $0}'
fi


#file_row_num的获取方法可以使用下面几种
awk '{print NR}' file.txt | tail -n1

awk 'END{print NR}' file.txt

grep -nc "" file.txt

grep -c "" file.txt

grep -vc "^$" file.txt

grep -n "" file.txt | awk -F: '{print '} | tail -n1 | cut -d: -f1

grep -nc "" file.txt

sed -n "$=" file.txt

wc -l file.txt

cat file.txt | wc -l

wc -l file.txt | cut -d' ' -f1