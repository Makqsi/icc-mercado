#!/bin/bash

read -p "Are you sure? (Y/N)" -n 1 -r
echo    # (optional) move to a new line
if [[ ! $REPLY =~ ^[Yy]$ ]]
then
	echo MERGING EVERYTHING FROM SYNC...
	git checkout
	echo UPDATING SYNC...
	git checkout sync
	git merge origin/sync
	echo UPDATING DEVELOPMENT...
	git checkout development
	git merge origin/development
	echo UPDATING MASTER...
	git checkout master
	git merge origin/master
	echo PROJECT UPDATED!
    exit 1
fi

