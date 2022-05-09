#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java amuriel.school21.Simulator scenario.txt