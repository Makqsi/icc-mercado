#!/bin/bash

cd icc-mercado
echo FETCHING ORIGIN...
git fetch origin
echo ATUALIZANDO SYNC...
git checkout sync
git merge origin/sync
echo ATUALIZANDO DEVELOPMENT...
git checkout development
git merge origin/development
echo ATUALIZANDO MASTER...
git checkout master
git merge origin/master
echo DIRETORIO ATUALIZADO!
