#!/bin/bash

git checkout develop && git pull
echo "Enter feat branch name. (example: new-feature)"
read name
git checkout -b feat/$name develop
