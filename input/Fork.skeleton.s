align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Fork_methods
global Fork_pickup 
global Fork_putdown 
global Fork_init 
; global methods declare

Fork_init:
Fork_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Fork_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; avail 
    MOV  DWORD [EAX + 4096 - 20 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 20 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 20 - 4]
    MOV  DWORD [EAX + 4096 - 20 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 20]
    MOV  DWORD [EAX + 4096 - 20], ECX       ; Pre EBP
    ADD  DWORD EAX, 4096 - 20
    ; init code goes here

    ; Fork_init_code

    MOV DWORD [EAX + 16], 1
 
    ; init code ends here
    RET

;define method Fork_pickup
Fork_pickup:
Fork_pickup_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Fork_pickup_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Fork_pickup_suspend
Fork_pickup_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 1
    JE Fork_pickup_succeed

    ; method guard ends here
Fork_pickup_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Fork_pickup_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Fork_pickup_start
Fork_pickup_succeed:
    ; method body starts here
    ;Fork_pickup_body
    ; method body ends here
Fork_pickup_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Fork_pickup_ret:
    RET
 
;define method Fork_putdown
Fork_putdown:
Fork_putdown_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Fork_putdown_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Fork_putdown_suspend
Fork_putdown_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 1
    JNE Fork_putdown_succeed


    ; method guard ends here
Fork_putdown_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Fork_putdown_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Fork_putdown_start
Fork_putdown_succeed:
    ; method body starts here
    ;Fork_putdown_body
    ; method body ends here
Fork_putdown_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Fork_putdown_ret:
    RET
 