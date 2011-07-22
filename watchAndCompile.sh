#!/bin/bash

MONITOR_COMMAND="inotifywait -q -e modify  --format '%w%f' --excludei '.*temp.*' ."

while true
do
  OUTPUT=`$MONITOR_COMMAND` && \
    pdflatex -output-directory=. 0001-start.tex
done;
