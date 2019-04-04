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
; global Test_methods
global Test_init 
; global methods declare

Test_init:
Test_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Test_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; v 
    MOV  DWORD [EAX + 4096 - 20 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 20 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 20 - 4]
    MOV  DWORD [EAX + 4096 - 20 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 20]
    MOV  DWORD [EAX + 4096 - 20], ECX       ; Pre EBP
    ADD  DWORD EAX, 4096 - 20
    ; init code goes here

    ; Test_init_code

 
    ; init code ends here
    RET
