#!/usr/bin/evn python
# -*- coding: UTF-8 -*-

for i in range(1, 10):
  line = ''
  for j in range(1, i + 1):
    line = line + "%d*%d = %2d  " % (j, i, j*i)
  print line

