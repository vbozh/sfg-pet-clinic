#!/usr/bin/env bash
# mr-qa startup-script probe for multi-repo QA
echo ">>> MR-QA STARTUP RAN repo=sfg-pet-clinic cwd=$(pwd) at $(date -u +%FT%TZ)"
echo "repo=sfg-pet-clinic cwd=$(pwd) at $(date -u +%FT%TZ)" > "$HOME/.startup-sfg-pet-clinic-ran"
exit 0
