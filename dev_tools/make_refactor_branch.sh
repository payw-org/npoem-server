#!/bin/bash

git checkout develop && git pull
echo "Enter refactor branch name. (example: something-refactor)"
read name
git checkout -b refactor/$name develop
