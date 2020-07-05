/*
 * atomic_instr.c
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */
#include <stdio.h>
#include <stdlib.h>

#include "atomic_instr.h"

void atomic_Store(unsigned int *ptr, unsigned int val){
    __atomic_store_n(ptr, val, __ATOMIC_RELEASE);   // store-release
}

int atomic_Load(unsigned int *ptr){
    return __atomic_load_n (ptr, __ATOMIC_ACQUIRE);  // load-acquire
}

int atomic_Cas(unsigned int *ptr,unsigned int *expected, unsigned int desired){   // CAS-release
    return __atomic_compare_exchange_n(ptr, expected, desired, 0, __ATOMIC_RELEASE, __ATOMIC_RELAXED);
}