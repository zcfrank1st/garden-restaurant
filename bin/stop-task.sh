#!/usr/bin/env bash
pid=`jcmd | grep garden | awk '{print $1}'`
kill -9 ${pid}