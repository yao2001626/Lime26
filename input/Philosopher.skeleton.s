align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern print 
extern Fork_pickup 
extern Fork_putdown 
; global methods declare
; global Philosopher_methods
global Philosopher_init 
; global methods declare

Philosopher_init:
Philosopher_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Philosopher_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; leftFork 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; rightFork 
    MOV  DWORD [EAX + 4096 - 24 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 24 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 24 - 4]
    MOV  DWORD [EAX + 4096 - 24 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 24]
    MOV  DWORD [EAX + 4096 - 24], ECX       ; Pre EBP
    LEA  ECX,  [Philosopher_doactions]
    MOV  DWORD [EAX + 4096 - 24 - 4], ECX   ; Philosopher_doactions
    ADD  DWORD EAX, 4096 - 24
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Philosopher_init_code

    MOV DWORD ECX, [ESP + 8]
    MOV DWORD [EAX + 20], ECX
    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 16], ECX
 
    ; init code ends here
    RET
Philosopher_doactions:
Philosopher_doactions_start:
    PUSH DWORD EBP
    ; CALL Philosopher_action
    CALL Philosopher_eat
    CALL Philosopher_think
    POP  EBP
    PUSH DWORD EBP
    CALL runqput
    POP  DWORD EBP
    CALL switch_to_sched
    JMP  Philosopher_doactions_start
    RET  ; never be here

; define action
; Philosopher: eat 
Philosopher_eat:
Philosopher_eat_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; action guard end
	JMP Philosopher_eat_succeed

Philosopher_eat_checkguard_fail:
	RET
Philosopher_eat_succeed:
    ; action body start
    ;Philosopher_eat_body
    ; action body end
    RET
; define action
; Philosopher: think 
Philosopher_think:
Philosopher_think_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; action guard end
	JMP Philosopher_think_succeed

Philosopher_think_checkguard_fail:
	RET
Philosopher_think_succeed:
    ; action body start
    ;Philosopher_think_body
    ; action body end
    RET