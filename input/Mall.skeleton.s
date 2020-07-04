align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Mall_methods
global Mall_arrive 
global Mall_init 
; global methods declare

Mall_init:
Mall_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Mall_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; s 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; firstCol 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; sndCol 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; firstCham 
    MOV  DWORD [EAX + 4096 - 5*4], 0    ; sndCham 
    MOV  DWORD [EAX + 4096 - 6*4], 0    ; repeat 
    MOV  DWORD [EAX + 4096 - 7*4], 0    ; N 
    MOV  DWORD [EAX + 4096 - 44 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 44 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 44 - 4]
    MOV  DWORD [EAX + 4096 - 44 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 44]
    MOV  DWORD [EAX + 4096 - 44], ECX       ; Pre EBP
    LEA  ECX,  [Mall_doactions]
    MOV  DWORD [EAX + 4096 - 44 - 4], ECX   ; Mall_doactions
    ADD  DWORD EAX, 4096 - 44
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Mall_init_code

    MOV DWORD [EAX + 16], 0
    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 40], ECX
 
    ; init code ends here
    RET
Mall_doactions:
Mall_doactions_start:
    PUSH DWORD EBP
    ; CALL Mall_action
    CALL Mall_mutate
    POP  EBP
    CALL switch_to_sched
    JMP  Mall_doactions_start
    RET  ; never be here
;define method Mall_arrive
Mall_arrive:
Mall_arrive_start:
    MOV  DWORD ECX, [ESP + 4 + 4*2]   ; + 4 * num(para)
Mall_arrive_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Mall_arrive_suspend
Mall_arrive_checkguard:
    ; method guard starts here
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 0
    JE Mall_arrive_succeed
    Mall_guard_101:
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 1
    JE Mall_arrive_succeed

    ; method guard ends here
Mall_arrive_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Mall_arrive_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Mall_arrive_start
Mall_arrive_succeed:
    ; method body starts here
    ;Mall_arrive_body
    ; method body ends here
Mall_arrive_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*2]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Mall_arrive_ret:
    RET
 ; define action
; Mall: mutate 
Mall_mutate:
Mall_mutate_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 16]
    CMP EDX, 2
    JE Mall_mutate_succeed

    ; action guard end
Mall_mutate_checkguard_fail:
	RET
Mall_mutate_succeed:
    ; action body start
    ;Mall_mutate_body
    ; action body end
    RET