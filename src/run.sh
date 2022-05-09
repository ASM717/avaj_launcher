#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java amuriel.school21.Simulator md5scenario.txt