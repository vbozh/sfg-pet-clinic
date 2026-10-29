#!/usr/bin/env bash
L="$HOME/mr-qa-order.log"
echo "$(date -u +%H:%M:%S.%N | cut -c1-12) START sfg-pet-clinic pid=$$ ppid=$PPID cwd=$(pwd)" >> "$L"
sleep 20
echo "$(date -u +%H:%M:%S.%N | cut -c1-12) END   sfg-pet-clinic" >> "$L"
exit 0