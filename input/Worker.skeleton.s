align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
; global methods declare
; global Worker_methods
global Worker_recipient 
global Worker_start 
global Worker_ping 
global Worker_pong 
global Worker_init 
; global methods declare

Worker_init:
Worker_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Worker_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; id 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; neighbours 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; sup 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; rand 
    MOV  DWORD [EAX + 4096 - 5*4], 0    ; pingpong 
    MOV  DWORD [EAX + 4096 - 6*4], 0    ; r 
    MOV  DWORD [EAX + 4096 - 40 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 40 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 40 - 4]
    MOV  DWORD [EAX + 4096 - 40 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 40]
    MOV  DWORD [EAX + 4096 - 40], ECX       ; Pre EBP
    LEA  ECX,  [Worker_doactions]
    MOV  DWORD [EAX + 4096 - 40 - 4], ECX   ; Worker_doactions
    ADD  DWORD EAX, 4096 - 40
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Worker_init_code

    MOV DWORD [EAX + 36], -1
    MOV DWORD ECX, [ESP + 8]
    MOV DWORD [EAX + 20], ECX
    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 16], ECX
    MOV DWORD ECX, [ESP + 12]
    MOV DWORD [EAX + 24], ECX
 
    ; init code ends here
    RET
Worker_doactions:
Worker_doactions_start:
    PUSH DWORD EBP
    ; CALL Worker_action
    CALL Worker_pingNeighbour
    CALL Worker_callSupervisor
    POP  EBP
    CALL switch_to_sched
    JMP  Worker_doactions_start
    RET  ; never be here
;define method Worker_recipient
Worker_recipient:
Worker_recipient_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Worker_recipient_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Worker_recipient_suspend
Worker_recipient_checkguard:
    ; method guard starts here
    ; method guard ends here
Worker_recipient_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Worker_recipient_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Worker_recipient_start
Worker_recipient_succeed:
    ; method body starts here
    ;Worker_recipient_body
    ; method body ends here
Worker_recipient_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Worker_recipient_ret:
    RET ;define method Worker_start
Worker_start:
Worker_start_start:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
Worker_start_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Worker_start_suspend
Worker_start_checkguard:
    ; method guard starts here
    ; method guard ends here
Worker_start_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Worker_start_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Worker_start_start
Worker_start_succeed:
    ; method body starts here
    ;Worker_start_body
    ; method body ends here
Worker_start_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*0]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Worker_start_ret:
    RET ;define method Worker_ping
Worker_ping:
Worker_ping_start:
    MOV  DWORD ECX, [ESP + 4 + 4*2]   ; + 4 * num(para)
Worker_ping_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Worker_ping_suspend
Worker_ping_checkguard:
    ; method guard starts here
    ; method guard ends here
Worker_ping_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Worker_ping_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Worker_ping_start
Worker_ping_succeed:
    ; method body starts here
    ;Worker_ping_body
    ; method body ends here
Worker_ping_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*2]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Worker_ping_ret:
    RET ;define method Worker_pong
Worker_pong:
Worker_pong_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Worker_pong_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Worker_pong_suspend
Worker_pong_checkguard:
    ; method guard starts here
    ; method guard ends here
Worker_pong_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Worker_pong_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Worker_pong_start
Worker_pong_succeed:
    ; method body starts here
    ;Worker_pong_body
    ; method body ends here
Worker_pong_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Worker_pong_ret:
    RET ; define action
; Worker: pingNeighbour 
Worker_pingNeighbour:
Worker_pingNeighbour_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 36]
    CMP EDX, 0
    JG Worker_pingNeighbour_succeed

    ; action guard end
Worker_pingNeighbour_checkguard_fail:
	RET
Worker_pingNeighbour_succeed:
    ; action body start
    ;Worker_pingNeighbour_body
    ; action body end
    RET; define action
; Worker: callSupervisor 
Worker_callSupervisor:
Worker_callSupervisor_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EDX, [ECX + 36]
    CMP EDX, 0
    JE Worker_callSupervisor_succeed

    ; action guard end
Worker_callSupervisor_checkguard_fail:
	RET
Worker_callSupervisor_succeed:
    ; action body start
    ;Worker_callSupervisor_body
    ; action body end
    RET