align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
; global _PQ_methods
global _PQ_init 
global _PQ_empty 
global _PQ_add 
global _PQ_remove 
; global methods declare

_PQ_init:
_PQ_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   _PQ_init_realloc
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
    LEA  ECX,  [_PQ_doactions]
    MOV  DWORD [EAX + 32768 - 36 - 4], ECX   ; PQ_doactions
    ADD  DWORD EAX, 32768 - 36
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here
    _PQ_init_code 
    ; init code ends here
    RET

_PQ_doactions:
_PQ_doactions_start:
    PUSH DWORD EBP
    ; CALL PQ_action
    CALL _PQ_doAdd
    CALL _PQ_doRemove
    POP  EBP
    CALL switch_to_sched
    JMP  _PQ_doactions_start
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
    _PQ_empty_guard
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
    _PQ_empty_body
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
    _PQ_add_guard
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
    _PQ_add_body
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
    _PQ_remove_guard
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
    _PQ_remove_body
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
    _PQ_doAdd_guard
    ; action guard end

    JMP   _PQ_doAdd_checkguard_fail
_PQ_doAdd_succeed:
    ; action body start
    _PQ_doAdd_body
    ; action body end
_PQ_doAdd_checkguard_fail:
    RET; define action
; _PQ: doRemove 
_PQ_doRemove:
_PQ_doRemove_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    _PQ_doRemove_guard
    ; action guard end

    JMP   _PQ_doRemove_checkguard_fail
_PQ_doRemove_succeed:
    ; action body start
    _PQ_doRemove_body
    ; action body end
_PQ_doRemove_checkguard_fail:
    RET