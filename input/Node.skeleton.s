align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
; global _Node_methods
global _Node_init 
global _Node_add 
global _Node_has 
; global methods declare

_Node_init:
_Node_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   _Node_init_realloc
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
    LEA  ECX,  [_Node_doactions]
    MOV  DWORD [EAX + 32768 - 36 - 4], ECX   ; Node_doactions
    ADD  DWORD EAX, 32768 - 36
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here
    _Node_init_code 
    ; init code ends here
    RET

_Node_doactions:
_Node_doactions_start:
    PUSH DWORD EBP
    ; CALL Node_action
    CALL _Node_addToChild
    POP  EBP
    CALL switch_to_sched
    JMP  _Node_doactions_start
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
    _Node_add_guard
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
    _Node_add_body
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
    _Node_has_guard
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
    _Node_has_body
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
    _Node_addToChild_guard
    ; action guard end

    JMP   _Node_addToChild_checkguard_fail
_Node_addToChild_succeed:
    ; action body start
    _Node_addToChild_body
    ; action body end
_Node_addToChild_checkguard_fail:
    RET