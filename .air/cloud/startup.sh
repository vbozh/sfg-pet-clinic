#!/usr/bin/env bash
echo "repo=sfg-pet-clinic FAILING cwd=$(pwd) at $(date -u +%FT%TZ)" > "$HOME/.startup-sfg-pet-clinic-ran"
echo ">>> MR-QA STARTUP FAILING ON PURPOSE" >&2
exit 3
