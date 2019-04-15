align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern print 
extern importedFun 
; global methods declare
; global Reducer_methods
global Reducer_init 
global Reducer_reduce1 
global Reducer_reduce2 
; global methods declare

Reducer_init:
Reducer_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Reducer_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; index 
    MOV  DWORD [EAX + 4096 - 2*4], 0    ; next 
    MOV  DWORD [EAX + 4096 - 3*4], 0    ; a1 
    MOV  DWORD [EAX + 4096 - 4*4], 0    ; a2 
    MOV  DWORD [EAX + 4096 - 5*4], 0    ; e1 
    MOV  DWORD [EAX + 4096 - 6*4], 0    ; e2 
    MOV  DWORD [EAX + 4096 - 40 + 12], 0    ; next
    MOV  DWORD [EAX + 4096 - 40 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 40 - 4]
    MOV  DWORD [EAX + 4096 - 40 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 40]
    MOV  DWORD [EAX + 4096 - 40], ECX       ; Pre EBP
    LEA  ECX,  [Reducer_doactions]
    MOV  DWORD [EAX + 4096 - 40 - 4], ECX   ; Reducer_doactions
    ADD  DWORD EAX, 4096 - 40
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Reducer_init_code

    MOV DWORD ECX, [ESP + 8]
    MOV DWORD [EAX + 20], ECX
    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 16], ECX
 
    ; init code ends here
    RET
Reducer_doactions:
Reducer_doactions_start:
    PUSH DWORD EBP
    ; CALL Reducer_action
    CALL Reducer_doReduce
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_doactions_start
    RET  ; never be here
;define method Reducer_reduce1
Reducer_reduce1:
Reducer_reduce1_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Reducer_reduce1_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Reducer_reduce1_suspend
Reducer_reduce1_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 24]
    CMP EAX, 1
    JNE Reducer_reduce1_succeed


    ; method guard ends here
Reducer_reduce1_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Reducer_reduce1_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_reduce1_start
Reducer_reduce1_succeed:
    ; method body starts here
    ;Reducer_reduce1_body
    ; method body ends here
Reducer_reduce1_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Reducer_reduce1_ret:
    RET ;define method Reducer_reduce2
Reducer_reduce2:
Reducer_reduce2_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Reducer_reduce2_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Reducer_reduce2_suspend
Reducer_reduce2_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 28]
    CMP EAX, 1
    JNE Reducer_reduce2_succeed


    ; method guard ends here
Reducer_reduce2_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Reducer_reduce2_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_reduce2_start
Reducer_reduce2_succeed:
    ; method body starts here
    ;Reducer_reduce2_body
    ; method body ends here
Reducer_reduce2_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    ; unlock
    MOV DWORD [ECX + 8], 0
Reducer_reduce2_ret:
    RET ; define action
; Reducer: doReduce 
Reducer_doReduce:
Reducer_doReduce_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EAX, [ECX + 24]
    CMP EAX, 1
    JNE Reducer_doReduce_checkguard_fail

    Reducer_guard_101:
    MOV DWORD EAX, [ECX + 28]
    CMP EAX, 1
    JE Reducer_doReduce_succeed

    ; action guard end
Reducer_doReduce_checkguard_fail:
	RET
Reducer_doReduce_succeed:
    ; action body start
    ;Reducer_doReduce_body
    ; action body end
    RET