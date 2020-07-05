align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern Santa_puzzled 
extern Santa_consult 
extern Santa_enter 
; global methods declare
; global Shop_methods
global Shop_init 
global Shop_puzzled 
global Shop_enter 
global Shop_consult 
; global methods declare

Shop_init:
Shop_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Shop_init_realloc
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

    ; Shop_init_code

    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 24], ECX
    MOV DWORD [EAX + 16], 8
 
    ; init code ends here
    RET
;define method Shop_puzzled
Shop_puzzled:
Shop_puzzled_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Shop_puzzled_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Shop_puzzled_suspend
Shop_puzzled_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 8
    JE Shop_puzzled_succeed

    ; method guard ends here
Shop_puzzled_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Shop_puzzled_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Shop_puzzled_start
Shop_puzzled_succeed:
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
	add	eax, 1
	mov	edx, dword   [esp + 32]
	mov	dword   [edx + 20], eax
	mov	eax, dword   [esp + 32]
	cmp	dword   [eax + 20], 3
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	jne	.LBB0_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 9
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Santa_puzzled
.LBB0_2:
	add	esp, 28
	;ret
.Lfunc_end0:
	;.size	Shop_puzzled, .Lfunc_end0-Shop_puzzled

    ; method body ends here
Shop_puzzled_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Shop_puzzled_ret:
    RET ;define method Shop_enter
Shop_enter:
Shop_enter_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Shop_enter_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Shop_enter_suspend
Shop_enter_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 9
    JE Shop_enter_succeed

    ; method guard ends here
Shop_enter_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Shop_enter_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Shop_enter_start
Shop_enter_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 10
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	edx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], edx
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	call	Santa_enter
	add	esp, 28
	;ret
.Lfunc_end1:
	;.size	Shop_enter, .Lfunc_end1-Shop_enter

    ; method body ends here
Shop_enter_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Shop_enter_ret:
    RET ;define method Shop_consult
Shop_consult:
Shop_consult_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Shop_consult_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Shop_consult_suspend
Shop_consult_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 10
    JE Shop_consult_succeed

    ; method guard ends here
Shop_consult_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Shop_consult_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Shop_consult_start
Shop_consult_succeed:
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
	jle	.LBB2_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 9
	jmp	.LBB2_3
.LBB2_2:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 16], 8
.LBB2_3:
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Santa_consult
	add	esp, 28
	;ret
.Lfunc_end2:
	;.size	Shop_consult, .Lfunc_end2-Shop_consult

    ; method body ends here
Shop_consult_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Shop_consult_ret:
    RET 