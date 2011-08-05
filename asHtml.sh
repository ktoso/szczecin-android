#!/bin/sh
gs -dNOPAUSE -g1024x768 -r205 -sDEVICE=pngalpha\
   -sOutputFile=./temp/slide_%d.png \
   -dBATCH 0004-widget.pdf

for i in *.png; do convert -resize 640x480 $i new/$i ; done

cd new/

ls

igal2 -r *
