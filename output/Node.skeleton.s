align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
global Node_init
; global Node_methods
; global methods declare

Node_init:
Node_init_realloc:
    PUSH DWORD 
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Node_init_realloc
    ; init code goes here
    ; 
    ; init code ends here
    MOV  DWORD [EAX + 8], 0              		; unlock
    RET

Node_doactions:
Node_doactions_start:
    PUSH DWORD EBP
    ; CALL Node_action
    POP  EBP
    CALL switch_to_sched
    JMP  Node_doactions_start
    RET  ; never be here
    ;define method
Node_add:
Node_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
Node_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node_add_suspend
Node_add_checkguard:
    ; method guard starts here
    ; 
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
    ; 
    ; method body ends here
Node_add_unlock:
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
Node_add_ret:
    RET ;define method
Node_has:
Node_has_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
Node_has_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node_has_suspend
Node_has_checkguard:
    ; method guard starts here
    ; 
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
    ; 
    ; method body ends here
Node_has_unlock:
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
Node_has_ret:
    RET ; define action
; Node: addToChild 
Node_action1:
Node_action1_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; 
    ; action guard end

    JE   Node_action1_guardfail
    ; action body start
    ; 
    ; action body end
Node_action1_guardfail:
    RET