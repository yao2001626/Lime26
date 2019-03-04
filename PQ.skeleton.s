align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
global PQ_init
; global PQ_methods
; global methods declare

PQ_init:
PQ_init_realloc:
    PUSH DWORD 
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   PQ_init_realloc
    ; init code goes here
    ; 
    ; init code ends here
    MOV  DWORD [EAX + 8], 0              		; unlock
    RET

PQ_doactions:
PQ_doactions_start:
    PUSH DWORD EBP
    ; CALL PQ_action
    POP  EBP
    CALL switch_to_sched
    JMP  PQ_doactions_start
    RET  ; never be here
    ;define method
PQ_empty:
PQ_empty_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(args)
PQ_empty_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_empty_suspend
PQ_empty_checkguard:
    ; method guard starts here
    ; 
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
    ; 
    ; method body ends here
PQ_empty_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(args)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
PQ_empty_ret:
    RET ;define method
PQ_add:
PQ_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
PQ_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_add_suspend
PQ_add_checkguard:
    ; method guard starts here
    ; 
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
    ; 
    ; method body ends here
PQ_add_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
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
    RET ;define method
PQ_remove:
PQ_remove_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(args)
PQ_remove_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  PQ_remove_suspend
PQ_remove_checkguard:
    ; method guard starts here
    ; 
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
    ; 
    ; method body ends here
PQ_remove_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(args)
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
    RET ; define action
; PQ: doAdd 
PQ_action4:
PQ_action4_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; 
    ; action guard end

    JE   PQ_action4_guardfail
    ; action body start
    ; 
    ; action body end
PQ_action4_guardfail:
    RET; define action
; PQ: doRemove 
PQ_action5:
PQ_action5_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; 
    ; action guard end

    JE   PQ_action5_guardfail
    ; action body start
    ; 
    ; action body end
PQ_action5_guardfail:
    RET