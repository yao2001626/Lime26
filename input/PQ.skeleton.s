align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern print 
extern getRand 
; global methods declare
; global PQ_methods
global PQ_init 
global PQ_empty 
global PQ_add 
global PQ_remove 
; global methods declare

PQ_init:
PQ_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   PQ_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; m 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; p 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; l 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; a 
    MOV  DWORD [EAX + 4096 - 5*4], 0    ; r 
    MOV  DWORD [EAX + 4096 - 36 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 36 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 36 - 4]
    MOV  DWORD [EAX + 4096 - 36 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 36]
    MOV  DWORD [EAX + 4096 - 36], ECX       ; Pre EBP
    LEA  ECX,  [PQ_doactions]
    MOV  DWORD [EAX + 4096 - 36 - 4], ECX   ; PQ_doactions
    ADD  DWORD EAX, 4096 - 36
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
    _PQ_empty_guard
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
    _PQ_empty_body
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
    _PQ_add_guard
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
    _PQ_add_body
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
    _PQ_remove_guard
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
    _PQ_remove_body
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
    _PQ_doAdd_guard
    ; action guard end
    JMP   PQ_doAdd_checkguard_fail
PQ_doAdd_succeed:
    ; action body start
    _PQ_doAdd_body
    ; action body end
PQ_doAdd_checkguard_fail:
    RET
; define action
; PQ: doRemove 
PQ_doRemove:
PQ_doRemove_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    _PQ_doRemove_guard
    ; action guard end
    JMP   PQ_doRemove_checkguard_fail
PQ_doRemove_succeed:
    ; action body start
    _PQ_doRemove_body
    ; action body end
PQ_doRemove_checkguard_fail:
    RET