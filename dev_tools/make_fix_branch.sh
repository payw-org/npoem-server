#!/bin/bash

git checkout develop && git pull
echo "Enter fix branch name. (example: something-improvement)"
read name
git checkout -b fix/$name develop
