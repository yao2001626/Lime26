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
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Node_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; key 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; p 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; left 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; right 
    MOV  DWORD [EAX + 4096 - 5*4], 0    ; a 
    MOV  DWORD [EAX + 4096 - 36 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 36 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 36 - 4]
    MOV  DWORD [EAX + 4096 - 36 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 36]
    MOV  DWORD [EAX + 4096 - 36], ECX       ; Pre EBP
    LEA  ECX,  [Node_doactions]
    MOV  DWORD [EAX + 4096 - 36 - 4], ECX   ; Node_doactions
    ADD  DWORD EAX, 4096 - 36
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
    _Node_add_guard
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
    _Node_add_body
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
    _Node_has_guard
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
    _Node_has_body
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
    _Node_addToChild_guard
    ; action guard end

    JMP   Node_addToChild_checkguard_fail
Node_addToChild_succeed:
    ; action body start
    _Node_addToChild_body
    ; action body end
Node_addToChild_checkguard_fail:
    RET