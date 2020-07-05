align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern Santa_pull 
extern Santa_harness 
extern Santa_back 
; global methods declare
; global Sleigh_methods
global Sleigh_init 
global Sleigh_back 
global Sleigh_harness 
global Sleigh_pull 
; global methods declare

Sleigh_init:
Sleigh_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Sleigh_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; s 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; c 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; st 
    MOV  DWORD [EAX + 4096 - 28 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 28 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 28 - 4]
    MOV  DWORD [EAX + 4096 - 28 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 28]
    MOV  DWORD [EAX + 4096 - 28], ECX       ; Pre EBP
    ADD  DWORD EAX, 4096 - 28
    ; init code goes here

    ; Sleigh_init_code

    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 24], ECX
    MOV DWORD [EAX + 16], 5
    MOV DWORD [EAX + 20], 9
 
    ; init code ends here
    RET
;define method Sleigh_back
Sleigh_back:
Sleigh_back_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Sleigh_back_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Sleigh_back_suspend
Sleigh_back_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 5
    JE Sleigh_back_succeed

    ; method guard ends here
Sleigh_back_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Sleigh_back_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Sleigh_back_start
Sleigh_back_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 20]
	sub	eax, 1
	mov	edx, dword   [esp + 32]
	mov	dword   [edx + 20], eax
	mov	eax, dword   [esp + 32]
	cmp	dword   [eax + 20], 0
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	jne	.LBB0_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 6
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 20], 9
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Santa_back
.LBB0_2:
	add	esp, 28
	;ret
.Lfunc_end0:
	;.size	Sleigh_back, .Lfunc_end0-Sleigh_back

    ; method body ends here
Sleigh_back_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Sleigh_back_ret:
    RET ;define method Sleigh_harness
Sleigh_harness:
Sleigh_harness_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Sleigh_harness_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Sleigh_harness_suspend
Sleigh_harness_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 6
    JE Sleigh_harness_succeed

    ; method guard ends here
Sleigh_harness_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Sleigh_harness_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Sleigh_harness_start
Sleigh_harness_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 20]
	sub	eax, 1
	mov	edx, dword   [esp + 32]
	mov	dword   [edx + 20], eax
	mov	eax, dword   [esp + 32]
	cmp	dword   [eax + 20], 0
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	jne	.LBB1_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 7
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 20], 9
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Santa_harness
.LBB1_2:
	add	esp, 28
	;ret
.Lfunc_end1:
	;.size	Sleigh_harness, .Lfunc_end1-Sleigh_harness

    ; method body ends here
Sleigh_harness_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Sleigh_harness_ret:
    RET ;define method Sleigh_pull
Sleigh_pull:
Sleigh_pull_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Sleigh_pull_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Sleigh_pull_suspend
Sleigh_pull_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 7
    JE Sleigh_pull_succeed

    ; method guard ends here
Sleigh_pull_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Sleigh_pull_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Sleigh_pull_start
Sleigh_pull_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 20]
	sub	eax, 1
	mov	edx, dword   [esp + 32]
	mov	dword   [edx + 20], eax
	mov	eax, dword   [esp + 32]
	cmp	dword   [eax + 20], 0
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	jne	.LBB2_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 5
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 20], 9
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Santa_pull
.LBB2_2:
	add	esp, 28
	;ret
.Lfunc_end2:
	;.size	Sleigh_pull, .Lfunc_end2-Sleigh_pull

    ; method body ends here
Sleigh_pull_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Sleigh_pull_ret:
    RET 