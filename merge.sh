#!/bin/bash
# Script by Paulo R. Almeida Filho 
#<palmeidaprogramming@gmail.com>

read -p "Merge everything with 'sync'? (Y/N) " -n 1 resp
echo    # (optional) move to a new line
if [[ $resp == "y" || $resp == "Y" ]];
then

	git checkout sync
	git push origin sync
	echo MERGING SYNC WITH DEVELOPMENT...
	git checkout development
	git merge sync
	git push origin development
	echo MERGING DEVELOPMENT WITH MASTER...
	git checkout master
	git merge development
	git push origin master
	git checkout sync
	echo ALL BRANCHES MERGED!
	echo You are in 'Sync' branch.
	
fi

