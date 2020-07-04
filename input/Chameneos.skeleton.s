align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Chameneos_methods
global Chameneos_meet 
global Chameneos_init 
; global methods declare

Chameneos_init:
Chameneos_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Chameneos_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; s 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; col 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; mall 
    MOV  DWORD [EAX + 4096 - 28 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 28 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 28 - 4]
    MOV  DWORD [EAX + 4096 - 28 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 28]
    MOV  DWORD [EAX + 4096 - 28], ECX       ; Pre EBP
    LEA  ECX,  [Chameneos_doactions]
    MOV  DWORD [EAX + 4096 - 28 - 4], ECX   ; Chameneos_doactions
    ADD  DWORD EAX, 4096 - 28
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Chameneos_init_code

    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 20], ECX
    MOV DWORD [EAX + 16], 0
    MOV DWORD ECX, [ESP + 8]
    MOV DWORD [EAX + 24], ECX
 
    ; init code ends here
    RET
Chameneos_doactions:
Chameneos_doactions_start:
    PUSH DWORD EBP
    ; CALL Chameneos_action
    CALL Chameneos_GoingToMall
    CALL Chameneos_BackToForest
    POP  EBP
    CALL switch_to_sched
    JMP  Chameneos_doactions_start
    RET  ; never be here
;define method Chameneos_meet
Chameneos_meet:
Chameneos_meet_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Chameneos_meet_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Chameneos_meet_suspend
Chameneos_meet_checkguard:
    ; method guard starts here
    ; method guard ends here
Chameneos_meet_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Chameneos_meet_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Chameneos_meet_start
Chameneos_meet_succeed:
    ; method body starts here
    ;Chameneos_meet_body
    ; method body ends here
Chameneos_meet_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Chameneos_meet_ret:
    RET
 ; define action
; Chameneos: GoingToMall 
Chameneos_GoingToMall:
Chameneos_GoingToMall_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 0
    JE Chameneos_GoingToMall_succeed

    ; action guard end
Chameneos_GoingToMall_checkguard_fail:
	RET
Chameneos_GoingToMall_succeed:
    ; action body start
    ;Chameneos_GoingToMall_body
    ; action body end
    RET; define action
; Chameneos: BackToForest 
Chameneos_BackToForest:
Chameneos_BackToForest_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 1
    JE Chameneos_BackToForest_succeed

    ; action guard end
Chameneos_BackToForest_checkguard_fail:
	RET
Chameneos_BackToForest_succeed:
    ; action body start
    ;Chameneos_BackToForest_body
    ; action body end
    RET