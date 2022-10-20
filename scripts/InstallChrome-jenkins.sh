#!/bin/bash
set -ex
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo -S apt install ./google-chrome-stable_current_amd64.deb