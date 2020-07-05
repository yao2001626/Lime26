/*
 * atomic_instr.h
 *
 *  Created on: Feb. 19, 2019
 *      Author: yaos4
 */

#ifndef INC_ATOMIC_INSTR_H_
#define INC_ATOMIC_INSTR_H_
void atomic_Store(unsigned int *ptr, unsigned int val);
int atomic_Load(unsigned int *ptr);
int atomic_Cas(unsigned int *ptr, unsigned int *expected, unsigned int desired);
#endif /* INC_ATOMIC_INSTR_H_ */
