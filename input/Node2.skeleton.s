align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Node2_methods
global Node2_init 
global Node2_add 
global Node2_has 
; global methods declare

Node2_init:
Node2_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Node2_init_realloc
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
    ADD  DWORD EAX, 4096 - 36
    ; init code goes here

    ; Node2_init_code

    MOV DWORD ECX, [ESP + 4]
    	MOV DWORD [EAX + 16], ECX
    	 
    ; init code ends here
    RET
;define method Node2_add
Node2_add:
Node2_add_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node2_add_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node2_add_suspend
Node2_add_checkguard:
    ; method guard starts here
    _Node2_add_guard
    ; method guard ends here
Node2_add_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node2_add_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node2_add_start
Node2_add_succeed:
    ; method body starts here
    _Node2_add_body
    ; method body ends here
Node2_add_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Node2_add_ret:
    RET ;define method Node2_has
Node2_has:
Node2_has_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Node2_has_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Node2_has_suspend
Node2_has_checkguard:
    ; method guard starts here
    _Node2_has_guard
    ; method guard ends here
Node2_has_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Node2_has_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Node2_has_start
Node2_has_succeed:
    ; method body starts here
    _Node2_has_body
    ; method body ends here
Node2_has_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Node2_has_ret:
    RET 