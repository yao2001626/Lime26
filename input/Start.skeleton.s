align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern PQ_add 
extern PQ_remove 
; global methods declare
; global Start_methods
global Start_init 
; global methods declare

Start_init:
Start_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Start_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; head 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; i 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; num 
    MOV  DWORD [EAX + 4096 - 28 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 28 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 28 - 4]
    MOV  DWORD [EAX + 4096 - 28 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 28]
    MOV  DWORD [EAX + 4096 - 28], ECX       ; Pre EBP
    ADD  DWORD EAX, 4096 - 28
    ; init code goes here

    ; Start_init_code

 
    ; init code ends here
    RET
