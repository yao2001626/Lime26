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

    ; PQ_init_code

 
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
    RET  ; never be here
;define method PQ_empty
PQ_empty:
PQ_empty_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
PQ_empty_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_empty_suspend
PQ_empty_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JNE PQ_empty_succeed

    ; method guard ends here
PQ_empty_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
PQ_empty_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  PQ_empty_start
PQ_empty_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	push	eax
	;_def_cfa_offset 8
	mov	eax, dword   [esp + 8]
	mov	ecx, dword   [esp + 8]
	cmp	dword   [ecx + 24], 0
	sete	dl
	and	dl, 1
	movzx	ecx, dl
	mov	dword   [esp], eax    ; 4-byte Spill
	mov	eax, ecx
	pop	ecx
	;ret
.Lfunc_end0:
	;.size	PQ_empty, .Lfunc_end0-PQ_empty

    ; method body ends here
PQ_empty_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
PQ_empty_ret:
    RET ;define method PQ_add
PQ_add:
PQ_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
PQ_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_add_suspend
PQ_add_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 28]
MOV DWORD EAX, [ECX + 32]
CMP DWORD EDX, 1
JE PQ_add_checkguard_fail
CMP DWORD EAX, 1
JNE PQ_add_succeed

    ; method guard ends here
PQ_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
PQ_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  PQ_add_start
PQ_add_succeed:
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
	jne	.LBB1_2
; %bb.1:
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 16], eax
	call	PQ_init
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 24], eax
	jmp	.LBB1_3
.LBB1_2:
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 20], eax
	mov	eax, dword   [esp + 8]
	mov	dword   [eax + 28], 1
.LBB1_3:
	add	esp, 12
	;ret
.Lfunc_end1:
	;.size	PQ_add, .Lfunc_end1-PQ_add

    ; method body ends here
PQ_add_unlock:
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
PQ_add_ret:
    RET ;define method PQ_remove
PQ_remove:
PQ_remove_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
PQ_remove_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_remove_suspend
PQ_remove_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 28]
MOV DWORD EDX, [ECX + 32]
CMP DWORD EAX, 1
JE PQ_remove_checkguard_fail
CMP DWORD EDX, 1
JNE PQ_remove_succeed

    ; method guard ends here
PQ_remove_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
PQ_remove_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  PQ_remove_start
PQ_remove_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	push	eax
	;_def_cfa_offset 8
	mov	eax, dword   [esp + 8]
	mov	ecx, dword   [esp + 8]
	mov	dword   [ecx + 32], 1
	mov	ecx, dword   [esp + 8]
	mov	ecx, dword   [ecx + 16]
	mov	dword   [esp], eax    ; 4-byte Spill
	mov	eax, ecx
	pop	ecx
	;ret
.Lfunc_end2:
	;.size	PQ_remove, .Lfunc_end2-PQ_remove

    ; method body ends here
PQ_remove_unlock:
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
PQ_remove_ret:
    RET 
; define action
; PQ: doAdd 
PQ_doAdd:
PQ_doAdd_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 28]
CMP DWORD EDX, 1
JE PQ_doAdd_succeed

    ; action guard end

    JMP   PQ_doAdd_checkguard_fail
PQ_doAdd_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 16]
	mov	edx, dword   [esp + 16]
	cmp	ecx, dword   [edx + 20]
	mov	dword   [esp + 8], eax ; 4-byte Spill
	jge	.LBB3_2
; %bb.1:
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	PQ_add
	jmp	.LBB3_3
.LBB3_2:
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 16]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	PQ_add
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [ecx + 16], eax
.LBB3_3:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 28], 0
	add	esp, 12
	;ret
.Lfunc_end3:
	;.size	PQ_doAdd, .Lfunc_end3-PQ_doAdd

    ; action body end
PQ_doAdd_checkguard_fail:
    RET
; define action
; PQ: doRemove 
PQ_doRemove:
PQ_doRemove_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 32]
CMP DWORD EDX, 1
JE PQ_doRemove_succeed

    ; action guard end

    JMP   PQ_doRemove_checkguard_fail
PQ_doRemove_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 16]
	mov	ecx, dword   [esp + 16]
	mov	ecx, dword   [ecx + 24]
	mov	dword   [esp], ecx
	mov	dword   [esp + 8], eax ; 4-byte Spill
	call	PQ_empty
	cmp	eax, 0
	je	.LBB4_2
; %bb.1:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 24], 0
	jmp	.LBB4_3
.LBB4_2:
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 24]
	mov	dword   [esp], eax
	call	PQ_remove
	mov	ecx, dword   [esp + 16]
	mov	dword   [ecx + 16], eax
.LBB4_3:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 32], 0
	add	esp, 12
	;ret
.Lfunc_end4:
	;.size	PQ_doRemove, .Lfunc_end4-PQ_doRemove

    ; action body end
PQ_doRemove_checkguard_fail:
    RET