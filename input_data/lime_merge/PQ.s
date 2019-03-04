
align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
; global PQ_methods
global PQ_init 
global PQ_empty 
global PQ_add 
global PQ_remove 
; global methods declare

PQ_init:
PQ_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   PQ_init_realloc
    MOV  DWORD [EAX + 32768 - 1*4], 0    ; m 
    MOV  DWORD [EAX + 32768 - 2*4], 0    ; p 
    MOV  DWORD [EAX + 32768 - 3*4], 0    ; l 
    MOV  DWORD [EAX + 32768 - 4*4], 0    ; a 
    MOV  DWORD [EAX + 32768 - 5*4], 0    ; r 
    MOV  DWORD [EAX + 32768 - 36 + 12], 0    ; next
    MOV  DWORD [EAX + 32768 - 36 + 8], 0     ; lock
    LEA  ECX,  [EAX + 32768 - 36 - 4]
    MOV  DWORD [EAX + 32768 - 36 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 32768 - 36]
    MOV  DWORD [EAX + 32768 - 36], ECX       ; Pre EBP
    LEA  ECX,  [PQ_doactions]
    MOV  DWORD [EAX + 32768 - 36 - 4], ECX   ; PQ_doactions
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

PQ_doactions:
PQ_doactions_start:
    PUSH DWORD EBP
    ; CALL PQ_action
    CALL PQ_doAdd
    CALL PQ_doRemove
    POP  EBP
    CALL switch_to_sched
    JMP  PQ_doactions_start
    RET  ; never be here;define method _PQ_empty
_PQ_empty:
_PQ_empty_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
_PQ_empty_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _PQ_empty_suspend
_PQ_empty_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
    CMP DWORD EDX, 1
    JNE _PQ_empty_succeed

    ; method guard ends here
_PQ_empty_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_PQ_empty_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _PQ_empty_start
_PQ_empty_succeed:
    ; method body starts here
    _	.cfi_startproc
	movl	4(%esp), %ecx
	xorl	%eax, %eax
	cmpl	$0, 24(%ecx)
	sete	%al

    ; method body ends here
_PQ_empty_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
_PQ_empty_ret:
    RET ;define method _PQ_add
_PQ_add:
_PQ_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_PQ_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _PQ_add_suspend
_PQ_add_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 28]
    MOV DWORD EAX, [ECX + 32]
    CMP DWORD EDX, 1
    JE _PQ_add_checkguard_fail
    CMP DWORD EAX, 1
    JNE _PQ_add_succeed

    ; method guard ends here
_PQ_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_PQ_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _PQ_add_start
_PQ_add_succeed:
    ; method body starts here
    _	.cfi_startproc
	pushl	%esi
Lcfi0:
	.cfi_def_cfa_offset 8
	subl	$8, %esp
Lcfi1:
	.cfi_def_cfa_offset 16
Lcfi2:
	.cfi_offset %esi, -8
	movl	20(%esp), %esi
	movl	16(%esp), %eax
	cmpl	$0, 24(%esi)
	movl	%eax, 20(%esi)
	je	LBB1_1
	movl	$1, 28(%esi)
	jmp	LBB1_3
LBB1_1:
	calll	_PQ_init
	movl	%eax, 24(%esi)
LBB1_3:
	addl	$8, %esp
	popl	%esi

    ; method body ends here
_PQ_add_unlock:
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
_PQ_add_ret:
    RET ;define method _PQ_remove
_PQ_remove:
_PQ_remove_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
_PQ_remove_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _PQ_remove_suspend
_PQ_remove_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 28]
    MOV DWORD EDX, [ECX + 32]
    CMP DWORD EAX, 1
    JE _PQ_remove_checkguard_fail
    CMP DWORD EDX, 1
    JNE _PQ_remove_succeed

    ; method guard ends here
_PQ_remove_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_PQ_remove_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _PQ_remove_start
_PQ_remove_succeed:
    ; method body starts here
    _	.cfi_startproc
	movl	4(%esp), %eax
	movl	$1, 32(%eax)
	movl	16(%eax), %eax

    ; method body ends here
_PQ_remove_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
_PQ_remove_ret:
    RET ; define action
; _PQ: doAdd 
_PQ_doAdd:
_PQ_doAdd_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 28]
    CMP DWORD EDX, 1
    JE _PQ_doAdd_succeed

    ; action guard end

    JMP   _PQ_doAdd_checkguard_fail
_PQ_doAdd_succeed:
    ; action body start
    _	.cfi_startproc
	pushl	%edi
Lcfi3:
	.cfi_def_cfa_offset 8
	pushl	%esi
Lcfi4:
	.cfi_def_cfa_offset 12
	pushl	%eax
Lcfi5:
	.cfi_def_cfa_offset 16
Lcfi6:
	.cfi_offset %esi, -12
Lcfi7:
	.cfi_offset %edi, -8
	movl	16(%esp), %esi
	movl	16(%esi), %eax
	movl	20(%esi), %ecx
	cmpl	%ecx, %eax
	movl	24(%esi), %edi
	movl	24(%edi), %edx
	jge	LBB3_4
	testl	%edx, %edx
	movl	%ecx, 20(%edi)
	je	LBB3_2
	movl	$1, 28(%edi)
	jmp	LBB3_8
LBB3_4:
	testl	%edx, %edx
	movl	%eax, 20(%edi)
	je	LBB3_5
	movl	$1, 28(%edi)
	jmp	LBB3_7
LBB3_2:
	calll	_PQ_init
	movl	%eax, 24(%edi)
	jmp	LBB3_8
LBB3_5:
	calll	_PQ_init
	movl	%eax, 24(%edi)
LBB3_7:
	movl	20(%esi), %eax
	movl	%eax, 16(%esi)
LBB3_8:
	movl	$0, 28(%esi)
	addl	$4, %esp
	popl	%esi
	popl	%edi

    ; action body end
_PQ_doAdd__checkguard_fail:
    RET; define action
; _PQ: doRemove 
_PQ_doRemove:
_PQ_doRemove_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 28]
    CMP DWORD EDX, 1
    JE _PQ_doRemove_succeed

    ; action guard end

    JMP   _PQ_doRemove_checkguard_fail
_PQ_doRemove_succeed:
    ; action body start
    _	.cfi_startproc
	movl	4(%esp), %eax
	movl	24(%eax), %ecx
	cmpl	$0, 24(%ecx)
	je	LBB4_1
	movl	$0, 16(%eax)
	jmp	LBB4_3
LBB4_1:
	movl	$0, 24(%eax)
LBB4_3:
	movl	$0, 32(%eax)

    ; action body end
_PQ_doRemove__checkguard_fail:
    RET