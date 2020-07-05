align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Santa_methods
global Santa_init 
global Santa_back 
global Santa_harness 
global Santa_pull 
global Santa_puzzled 
global Santa_enter 
global Santa_consult 
; global methods declare

Santa_init:
Santa_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Santa_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; s 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; b 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; p 
    MOV  DWORD [EAX + 4096 - 28 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 28 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 28 - 4]
    MOV  DWORD [EAX + 4096 - 28 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 28]
    MOV  DWORD [EAX + 4096 - 28], ECX       ; Pre EBP
    LEA  ECX,  [Santa_doactions]
    MOV  DWORD [EAX + 4096 - 28 - 4], ECX   ; Santa_doactions
    ADD  DWORD EAX, 4096 - 28
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Santa_init_code

    MOV DWORD [EAX + 16], 0
 
    ; init code ends here
    RET
Santa_doactions:
Santa_doactions_start:
    PUSH DWORD EBP
    ; CALL Santa_action
    CALL Santa_action1
    CALL Santa_action2
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_doactions_start
    RET  ; never be here
;define method Santa_back
Santa_back:
Santa_back_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_back_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_back_suspend
Santa_back_checkguard:
    ; method guard starts here
	JMP Santa_back_succeed
    ; method guard ends here
Santa_back_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_back_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_back_start
Santa_back_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 20], 1
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end0:
	;.size	Santa_back, .Lfunc_end0-Santa_back

    ; method body ends here
Santa_back_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Santa_back_ret:
    RET ;define method Santa_harness
Santa_harness:
Santa_harness_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_harness_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_harness_suspend
Santa_harness_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 1
    JE Santa_harness_succeed

    ; method guard ends here
Santa_harness_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_harness_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_harness_start
Santa_harness_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 2
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end1:
	;.size	Santa_harness, .Lfunc_end1-Santa_harness

    ; method body ends here
Santa_harness_unlock:
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
Santa_harness_ret:
    RET ;define method Santa_pull
Santa_pull:
Santa_pull_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_pull_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_pull_suspend
Santa_pull_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 2
    JE Santa_pull_succeed

    ; method guard ends here
Santa_pull_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_pull_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_pull_start
Santa_pull_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 0
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 20], 0
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end2:
	;.size	Santa_pull, .Lfunc_end2-Santa_pull

    ; method body ends here
Santa_pull_unlock:
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
Santa_pull_ret:
    RET ;define method Santa_puzzled
Santa_puzzled:
Santa_puzzled_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_puzzled_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_puzzled_suspend
Santa_puzzled_checkguard:
    ; method guard starts here
	JMP Santa_puzzled_succeed
    ; method guard ends here
Santa_puzzled_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_puzzled_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_puzzled_start
Santa_puzzled_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 24], 3
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end3:
	;.size	Santa_puzzled, .Lfunc_end3-Santa_puzzled

    ; method body ends here
Santa_puzzled_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Santa_puzzled_ret:
    RET ;define method Santa_enter
Santa_enter:
Santa_enter_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_enter_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_enter_suspend
Santa_enter_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 3
    JE Santa_enter_succeed

    ; method guard ends here
Santa_enter_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_enter_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_enter_start
Santa_enter_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 4
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end4:
	;.size	Santa_enter, .Lfunc_end4-Santa_enter

    ; method body ends here
Santa_enter_unlock:
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
Santa_enter_ret:
    RET ;define method Santa_consult
Santa_consult:
Santa_consult_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Santa_consult_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Santa_consult_suspend
Santa_consult_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 4
    JE Santa_consult_succeed

    ; method guard ends here
Santa_consult_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Santa_consult_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Santa_consult_start
Santa_consult_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	eax, dword   [eax + 24]
	sub	eax, 1
	mov	edx, dword   [esp + 16]
	mov	dword   [edx + 24], eax
	mov	eax, dword   [esp + 16]
	cmp	dword   [eax + 24], 0
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	jle	.LBB5_2
; %bb.1:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 3
	jmp	.LBB5_3
.LBB5_2:
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 0
.LBB5_3:
	add	esp, 12
	;ret
.Lfunc_end5:
	;.size	Santa_consult, .Lfunc_end5-Santa_consult

    ; method body ends here
Santa_consult_unlock:
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
Santa_consult_ret:
    RET ; define action
; Santa: action1 
Santa_action1:
Santa_action1_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 0
    JNE Santa_action1_checkguard_fail

    Santa_guard_101:
    MOV DWORD EDX, [ECX + 20]
    CMP EDX, 1
    JE Santa_action1_succeed

    ; action guard end
Santa_action1_checkguard_fail:
	RET
Santa_action1_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 1
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end6:
	;.size	Santa_action1, .Lfunc_end6-Santa_action1

    ; action body end
    RET; define action
; Santa: action2 
Santa_action2:
Santa_action2_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 0
    JNE Santa_action2_checkguard_fail

    Santa_guard_102:
    MOV DWORD EDX, [ECX + 24]
    CMP EDX, 3
    JNE Santa_action2_checkguard_fail

    Santa_guard_103:
    MOV DWORD EDX, [ECX + 20]
    CMP EDX, 1
    JNE Santa_action2_succeed


    ; action guard end
Santa_action2_checkguard_fail:
	RET
Santa_action2_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	dword   [eax + 16], 3
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end7:
	;.size	Santa_action2, .Lfunc_end7-Santa_action2

    ; action body end
    RET