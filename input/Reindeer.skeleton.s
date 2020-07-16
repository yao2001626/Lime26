align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern Sleigh_pull 
extern Sleigh_back 
extern Sleigh_harness 
; global methods declare
; global Reindeer_methods
global Reindeer_init 
; global methods declare

Reindeer_init:
Reindeer_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Reindeer_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; sl 
    MOV  DWORD [EAX + 4096 - 20 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 20 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 20 - 4]
    MOV  DWORD [EAX + 4096 - 20 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 20]
    MOV  DWORD [EAX + 4096 - 20], ECX       ; Pre EBP
    LEA  ECX,  [Reindeer_doactions]
    MOV  DWORD [EAX + 4096 - 20 - 4], ECX   ; Reindeer_doactions
    ADD  DWORD EAX, 4096 - 20
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Reindeer_init_code

    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 16], ECX
 
    ; init code ends here
    RET
Reindeer_doactions:
Reindeer_doactions_start:
    PUSH DWORD EBP
    ; CALL Reindeer_action
    CALL Reindeer_action1
    POP  EBP
    PUSH DWORD EBP
    CALL runqput
    POP  DWORD EBP
    CALL switch_to_sched
    JMP  Reindeer_doactions_start
    RET  ; never be here

; define action
; Reindeer: action1 
Reindeer_action1:
Reindeer_action1_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; action guard end
	JMP Reindeer_action1_succeed

Reindeer_action1_checkguard_fail:
	RET
Reindeer_action1_succeed:
    ; action body start
    ;Reindeer_action1_body
    ; action body end
    RET