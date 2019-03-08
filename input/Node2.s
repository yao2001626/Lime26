align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Node2_methods
global Node2_init 
global Node2_add 
global Node2_has 
; global methods declare

Node2_init:
Node2_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Node2_init_realloc
    MOV  DWORD [EAX + 32768 - 1*4], 0    ; key 
    MOV  DWORD [EAX + 32768 - 2*4], 0    ; p 
    MOV  DWORD [EAX + 32768 - 3*4], 0    ; left 
    MOV  DWORD [EAX + 32768 - 4*4], 0    ; right 
    MOV  DWORD [EAX + 32768 - 5*4], 0    ; a 
    MOV  DWORD [EAX + 32768 - 36 + 12], 0    ; next
    MOV  DWORD [EAX + 32768 - 36 + 8], 0     ; lock
    LEA  ECX,  [EAX + 32768 - 36 - 4]
    MOV  DWORD [EAX + 32768 - 36 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 32768 - 36]
    MOV  DWORD [EAX + 32768 - 36], ECX       ; Pre EBP
    ADD  DWORD EAX, 32768 - 36
    ; init code goes here

    ; Node2_init_code

    MOV DWORD ECX, [ESP + 4]
    	MOV DWORD [EAX + 16], ECX
    	 
    ; init code ends here
    RET
;define method Node2_add
Node2_add:
Node2_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node2_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node2_add_suspend
Node2_add_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JNE Node2_add_succeed

    ; method guard ends here
Node2_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node2_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node2_add_start
Node2_add_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 24]
	cmp	dword   [eax + 24], 0
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	je	.LBB0_5
; %bb.1:
	mov	eax, dword   [esp + 24]
	mov	dword   [eax + 32], 1
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 20], eax
	mov	eax, dword   [esp + 24]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 24]
	cmp	eax, dword   [ecx + 16]
	jg	.LBB0_3
; %bb.2:
	mov	eax, dword   [esp + 24]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 24]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node2_add
	jmp	.LBB0_4
.LBB0_3:
	mov	eax, dword   [esp + 24]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 24]
	mov	ecx, dword   [ecx + 28]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node2_add
.LBB0_4:
	mov	eax, dword   [esp + 24]
	mov	dword   [eax + 32], 0
	jmp	.LBB0_11
.LBB0_5:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 24]
	cmp	eax, dword   [ecx + 16]
	jge	.LBB0_7
; %bb.6:
	mov	eax, dword   [esp + 32]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node2_init
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 24], eax
	mov	eax, dword   [esp + 24]
	mov	eax, dword   [eax + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node2_init
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 28], eax
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 16], eax
	jmp	.LBB0_10
.LBB0_7:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 24]
	cmp	eax, dword   [ecx + 16]
	jle	.LBB0_9
; %bb.8:
	mov	eax, dword   [esp + 24]
	mov	eax, dword   [eax + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node2_init
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 24], eax
	mov	eax, dword   [esp + 32]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node2_init
	mov	ecx, dword   [esp + 24]
	mov	dword   [ecx + 28], eax
.LBB0_9:
	jmp	.LBB0_10
.LBB0_10:
	jmp	.LBB0_11
.LBB0_11:
	add	esp, 28
	;ret
.Lfunc_end0:
	;.size	Node2_add, .Lfunc_end0-Node2_add

    ; method body ends here
Node2_add_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Node2_add_ret:
    RET ;define method Node2_has
Node2_has:
Node2_has_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node2_has_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node2_has_suspend
Node2_has_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JNE Node2_has_succeed

    ; method guard ends here
Node2_has_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node2_has_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node2_has_start
Node2_has_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 16], eax
	mov	eax, dword   [esp + 16]
	cmp	dword   [eax + 24], 0
	mov	dword   [esp + 12], ecx ; 4-byte Spill
	jne	.LBB1_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 16]
	cmp	eax, dword   [ecx + 16]
	sete	dl
	and	dl, 1
	movzx	eax, dl
	mov	dword   [esp + 24], eax
	jmp	.LBB1_5
.LBB1_2:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 16]
	cmp	eax, dword   [ecx + 16]
	jg	.LBB1_4
; %bb.3:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node2_has
	mov	dword   [esp + 24], eax
	jmp	.LBB1_5
.LBB1_4:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 28]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node2_has
	mov	dword   [esp + 24], eax
.LBB1_5:
	mov	eax, dword   [esp + 24]
	add	esp, 28
	;ret
.Lfunc_end1:
	;.size	Node2_has, .Lfunc_end1-Node2_has

    ; method body ends here
Node2_has_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Node2_has_ret:
    RET 