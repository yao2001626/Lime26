align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Supervisor_methods
global Supervisor_done 
global Supervisor_init 
; global methods declare

Supervisor_init:
Supervisor_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Supervisor_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; replies 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; min 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; max 
    MOV  DWORD [EAX + 4096 - 28 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 28 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 28 - 4]
    MOV  DWORD [EAX + 4096 - 28 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 28]
    MOV  DWORD [EAX + 4096 - 28], ECX       ; Pre EBP
    ADD  DWORD EAX, 4096 - 28
    ; init code goes here

    ; Supervisor_init_code

 
    ; init code ends here
    RET
;define method Supervisor_done
Supervisor_done:
Supervisor_done_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Supervisor_done_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Supervisor_done_suspend
Supervisor_done_checkguard:
    ; method guard starts here
    ; method guard ends here
Supervisor_done_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Supervisor_done_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Supervisor_done_start
Supervisor_done_succeed:
    ; method body starts here
    ;Supervisor_done_body
    ; method body ends here
Supervisor_done_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Supervisor_done_ret:
    RET
 