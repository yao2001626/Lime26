align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Node_methods
global Node_init 
global Node_add 
global Node_has 
; global methods declare

Node_init:
Node_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Node_init_realloc
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
    LEA  ECX,  [Node_doactions]
    MOV  DWORD [EAX + 32768 - 36 - 4], ECX   ; Node_doactions
    ADD  DWORD EAX, 32768 - 36
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Node_init_code

    MOV DWORD ECX, [ESP + 4]
    	MOV DWORD [EAX + 16], ECX
    	 
    ; init code ends here
    RET
Node_doactions:
Node_doactions_start:
    PUSH DWORD EBP
    ; CALL Node_action
    CALL Node_addToChild
    POP  EBP
    CALL switch_to_sched
    JMP  Node_doactions_start
    RET  ; never be here
;define method Node_add
Node_add:
Node_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node_add_suspend
Node_add_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JNE Node_add_succeed

    ; method guard ends here
Node_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node_add_start
Node_add_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 8]
	cmp	dword   [eax + 24], 0
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	je	.LBB0_2
; %bb.1:
	mov	eax, dword   [esp + 8]
	mov	dword   [eax + 32], 1
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 20], eax
	jmp	.LBB0_8
.LBB0_2:
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	cmp	eax, dword   [ecx + 16]
	jge	.LBB0_4
; %bb.3:
	mov	eax, dword   [esp + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node_init
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 24], eax
	mov	eax, dword   [esp + 8]
	mov	eax, dword   [eax + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node_init
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 28], eax
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 16], eax
	jmp	.LBB0_7
.LBB0_4:
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	cmp	eax, dword   [ecx + 16]
	jle	.LBB0_6
; %bb.5:
	mov	eax, dword   [esp + 8]
	mov	eax, dword   [eax + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node_init
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 24], eax
	mov	eax, dword   [esp + 16]
	mov	ecx, esp
	mov	dword   [ecx], eax
	call	Node_init
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 28], eax
.LBB0_6:
	jmp	.LBB0_7
.LBB0_7:
	jmp	.LBB0_8
.LBB0_8:
	add	esp, 12
	;ret
.Lfunc_end0:
	;.size	Node_add, .Lfunc_end0-Node_add

    ; method body ends here
Node_add_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
Node_add_ret:
    RET ;define method Node_has
Node_has:
Node_has_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node_has_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node_has_suspend
Node_has_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JNE Node_has_succeed

    ; method guard ends here
Node_has_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node_has_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node_has_start
Node_has_succeed:
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
	call	Node_has
	mov	dword   [esp + 24], eax
	jmp	.LBB1_5
.LBB1_4:
	mov	eax, dword   [esp + 32]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 28]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node_has
	mov	dword   [esp + 24], eax
.LBB1_5:
	mov	eax, dword   [esp + 24]
	add	esp, 28
	;ret
.Lfunc_end1:
	;.size	Node_has, .Lfunc_end1-Node_has

    ; method body ends here
Node_has_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Node_has_ret:
    RET 
; define action
; Node: addToChild 
Node_addToChild:
Node_addToChild_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JE Node_addToChild_succeed

    ; action guard end

    JMP   Node_addToChild_checkguard_fail
Node_addToChild_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 20]
	mov	edx, dword   [esp + 16]
	cmp	ecx, dword   [edx + 16]
	mov	dword   [esp + 8], eax ; 4-byte Spill
	jg	.LBB2_2
; %bb.1:
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node_add
	jmp	.LBB2_3
.LBB2_2:
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 28]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Node_add
.LBB2_3:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 32], 0
	add	esp, 12
	;ret
.Lfunc_end2:
	;.size	Node_addToChild, .Lfunc_end2-Node_addToChild

    ; action body end
Node_addToChild_checkguard_fail:
    RET