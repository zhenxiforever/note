Some Examples 
=============


* Fix Daily & Hourly Job

```bash 
#!/usr/bin/env bash

# set -x

if [ $# -ne 2 ]; then
  echo "Usage ./hourly_fix.sh <startDate> <endDate>"
  exit 1
fi

startDate="$1"
endDate="$2"

function runDailyJob {

    dealDate="$1"
    for ((j=0; j<=23; j++)); do
       echo "Run hourly job" 
    done
    echo "Run daily job"
}

echo "start date $startDate"
echo "end date $endDate"

hasDates=$(($(date -d $endDate +%j)-$(date -d $startDate +%j)))

for ((i=0; i<=$hasDates; i++)); do
    dealDate=$(date -d "$startDate +$i day" +%Y-%m-%d)
    #echo $dealDate
    runDailyJob $dealDate
done 
``` 

