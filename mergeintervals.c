/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 *
 * typedef struct Interval interval;
 */
/*
 * intervals : the array of interval
 * sz : number of entries in intervals
 * newInterval : new Interval to be inserted
 * len : populate the length of returned array of intervals in len
 */

int min(int a, int b){
    if(a<b){
        return a;
    }
    return b;
} 
 
int max(int a, int b){
    if(a>b){
        return a;
    }
    return b;
} 
 
interval* insert(interval *intervals, int sz, interval newInterval, int *len) {
    
    if(sz == 0){
        *len=0;
        return intervals;
    }
    
    if(newInterval.start > newInterval.end){
        int temp = newInterval.start;
        newInterval.start = newInterval.end;
        newInterval.end = temp;
    }
    
    //check special conditions first
    if(newInterval.end < intervals[0].start){
        //insert newInterval at the beginning
        interval* arr = (interval*)malloc(sizeof(interval)*(sz+1));
        *len = sz + 1;
        arr[0] = newInterval;
        int i =1;
        for(i=0; i<sz; i++){
            arr[i+1] = intervals[i];
        }
        
        return arr;
    }
    
    else if(newInterval.start > intervals[sz-1].end){
        //insert newInterval at the end
         interval* arr = (interval*)malloc(sizeof(interval)*(sz+1));
        *len = sz + 1;
        int i =0;
         for(i=0; i<sz; i++){
            arr[i] = intervals[i];
        }
        arr[i] = newInterval;
        return arr;
        //return intervals
    }
    
    else if((newInterval.start<= intervals[0].start) & (newInterval.end >= intervals[sz-1].end)){
        //newInterval covers all elements. return 1 element i.e. newInterval as part of intervals*
        interval* arr = (interval*)malloc(sizeof(interval)*(1));
        *len = 1;
        arr[0] = newInterval;
        return arr;
    }
    
    else{
        
        //check for overlaps and set flag. merge.
        int start=-1, end=-1, i=0;
        for(i=0; i<sz; i++){
            
            //overlap condition
            if(max(intervals[i].start, newInterval.start) < min(intervals[i].end, newInterval.end)){
                
                if(start == -1){
                    start = end = i;
                }
                
                else{
                    end = i;
                }
            }
        }
        
        //overlaps (from start till end index)
        if(start != -1){
            printf("%s", "overlaps");
            return intervals;
            //insert elements from 0 to start - 1
            //insert 1 combined (merged) element for start and end index
            //insert elements from end index +1 till (sz -1)th i.e the last index
            //return intervals
        }
        
        //no overlaps
        else{
            printf("%s", "does not overlap");
            return intervals;

         //insert element in between 2 intervals by finding the correct position
         //return intervals
        }
        
       
        
    } //else overlap or non-overlap condition
    
}
