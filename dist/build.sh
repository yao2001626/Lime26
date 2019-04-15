#!/bin/bash

#make clean

#make 

SCRIPT=`realpath $0`
SCRIPTPATH=`dirname $SCRIPT`

echo 'create limec in the /usr/bin...'

sudo ln -s $SCRIPTPATH'/limec' /usr/local/bin/limec   
