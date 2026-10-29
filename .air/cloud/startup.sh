#!/usr/bin/env bash
L="$HOME/mr-qa-apt.log"
echo "$(date -u +%H:%M:%S.%N | cut -c1-12) START sfg-pet-clinic" >> "$L"
sudo -E apt-get install -y --no-install-recommends cowsay > "$HOME/mr-qa-apt-sfg-pet-clinic.out" 2>&1
rc=$?
echo "$(date -u +%H:%M:%S.%N | cut -c1-12) END   sfg-pet-clinic apt_rc=$rc lock=$(grep -c -i 'lock' "$HOME/mr-qa-apt-sfg-pet-clinic.out")" >> "$L"
echo "export MRQA_OWNER=sfg-pet-clinic" >> "$HOME/.bashrc"
echo "sfg-pet-clinic" > "$HOME/.mrqa-owner"
exit $rc