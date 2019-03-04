
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
    ; 
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
    RET  ; never be here;define method _Node_add
_Node_add:
_Node_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_Node_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _Node_add_suspend
_Node_add_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
    CMP DWORD EDX, 1
    JNE _Node_add_succeed

    ; method guard ends here
_Node_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_Node_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _Node_add_start
_Node_add_succeed:
    ; method body starts here
    _	.cfi_startproc
	pushl	%edi
Lcfi0:
	.cfi_def_cfa_offset 8
	pushl	%esi
Lcfi1:
	.cfi_def_cfa_offset 12
	pushl	%eax
Lcfi2:
	.cfi_def_cfa_offset 16
Lcfi3:
	.cfi_offset %esi, -12
Lcfi4:
	.cfi_offset %edi, -8
	movl	20(%esp), %esi
	movl	16(%esp), %edi
	cmpl	$0, 24(%esi)
	je	LBB0_1
	movl	16(%esi), %eax
	cmpl	%edi, %eax
	jle	LBB0_4
	movl	%edi, (%esp)
	calll	_Node_init
	movl	%eax, 24(%esi)
	movl	16(%esi), %eax
	movl	%eax, (%esp)
	calll	_Node_init
	movl	%eax, 28(%esi)
	movl	%edi, 16(%esi)
	jmp	LBB0_6
LBB0_1:
	movl	$1, 32(%esi)
	movl	%edi, 20(%esi)
	jmp	LBB0_6
LBB0_4:
	jge	LBB0_6
	movl	%eax, (%esp)
	calll	_Node_init
	movl	%eax, 24(%esi)
	movl	%edi, (%esp)
	calll	_Node_init
	movl	%eax, 28(%esi)
LBB0_6:
	addl	$4, %esp
	popl	%esi
	popl	%edi

    ; method body ends here
_Node_add_unlock:
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
_Node_add_ret:
    RET ;define method _Node_has
_Node_has:
_Node_has_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_Node_has_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _Node_has_suspend
_Node_has_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
    CMP DWORD EDX, 1
    JNE _Node_has_succeed

    ; method guard ends here
_Node_has_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_Node_has_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _Node_has_start
_Node_has_succeed:
    ; method body starts here
    _	.cfi_startproc
	pushl	%esi
Lcfi5:
	.cfi_def_cfa_offset 8
Lcfi6:
	.cfi_offset %esi, -8
	movl	12(%esp), %eax
	movl	8(%esp), %ecx
	jmp	LBB1_1
LBB1_2:                                 ;   in Loop: Header=BB1_1 Depth=1
	cmpl	%ecx, %edx
	jge	LBB1_4
	movl	28(%eax), %esi
LBB1_4:                                 ;   in Loop: Header=BB1_1 Depth=1
	movl	%esi, %eax
LBB1_1:                                 ; =>This Inner Loop Header: Depth=1
	movl	16(%eax), %edx
	movl	24(%eax), %esi
	testl	%esi, %esi
	jne	LBB1_2
	xorl	%eax, %eax
	cmpl	%ecx, %edx
	sete	%al
	popl	%esi

    ; method body ends here
_Node_has_unlock:
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
_Node_has_ret:
    RET ; define action
; _Node: addToChild 
_Node_addToChild:
_Node_addToChild_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 32]
    CMP DWORD EDX, 1
    JE _Node_addToChild_succeed

    ; action guard end

    JMP   _Node_addToChild_checkguard_fail
_Node_addToChild_succeed:
    ; action body start
    _	.cfi_startproc
	pushl	%esi
Lcfi7:
	.cfi_def_cfa_offset 8
	subl	$8, %esp
Lcfi8:
	.cfi_def_cfa_offset 16
Lcfi9:
	.cfi_offset %esi, -8
	movl	16(%esp), %esi
	movl	20(%esi), %eax
	cmpl	16(%esi), %eax
	jle	LBB2_1
	movl	28(%esi), %ecx
	jmp	LBB2_3
LBB2_1:
	movl	24(%esi), %ecx
LBB2_3:
	movl	%ecx, 4(%esp)
	movl	%eax, (%esp)
	calll	_Node_add
	movl	$0, 32(%esi)
	addl	$8, %esp
	popl	%esi

    ; action body end
_Node_addToChild__checkguard_fail:
    RET