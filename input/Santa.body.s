	.text
	.intel_syntax noprefix
	.file	"Santa.c"
	.globl	Santa_back              # -- Begin function Santa_back
	.p2align	4, 0x90
	.type	Santa_back,@function
Santa_back:                             # @Santa_back
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 20], 1
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end0:
	.size	Santa_back, .Lfunc_end0-Santa_back
	.cfi_endproc
                                        # -- End function
	.globl	Santa_harness           # -- Begin function Santa_harness
	.p2align	4, 0x90
	.type	Santa_harness,@function
Santa_harness:                          # @Santa_harness
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 2
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end1:
	.size	Santa_harness, .Lfunc_end1-Santa_harness
	.cfi_endproc
                                        # -- End function
	.globl	Santa_pull              # -- Begin function Santa_pull
	.p2align	4, 0x90
	.type	Santa_pull,@function
Santa_pull:                             # @Santa_pull
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 0
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 20], 0
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end2:
	.size	Santa_pull, .Lfunc_end2-Santa_pull
	.cfi_endproc
                                        # -- End function
	.globl	Santa_puzzled           # -- Begin function Santa_puzzled
	.p2align	4, 0x90
	.type	Santa_puzzled,@function
Santa_puzzled:                          # @Santa_puzzled
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 24], 3
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end3:
	.size	Santa_puzzled, .Lfunc_end3-Santa_puzzled
	.cfi_endproc
                                        # -- End function
	.globl	Santa_enter             # -- Begin function Santa_enter
	.p2align	4, 0x90
	.type	Santa_enter,@function
Santa_enter:                            # @Santa_enter
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 4
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end4:
	.size	Santa_enter, .Lfunc_end4-Santa_enter
	.cfi_endproc
                                        # -- End function
	.globl	Santa_consult           # -- Begin function Santa_consult
	.p2align	4, 0x90
	.type	Santa_consult,@function
Santa_consult:                          # @Santa_consult
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 24]
	sub	eax, 1
	mov	edx, dword ptr [esp + 16]
	mov	dword ptr [edx + 24], eax
	mov	eax, dword ptr [esp + 16]
	cmp	dword ptr [eax + 24], 0
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	jle	.LBB5_2
# %bb.1:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 3
	jmp	.LBB5_3
.LBB5_2:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 0
.LBB5_3:
	add	esp, 12
	ret
.Lfunc_end5:
	.size	Santa_consult, .Lfunc_end5-Santa_consult
	.cfi_endproc
                                        # -- End function
	.globl	Santa_action1           # -- Begin function Santa_action1
	.p2align	4, 0x90
	.type	Santa_action1,@function
Santa_action1:                          # @Santa_action1
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 1
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end6:
	.size	Santa_action1, .Lfunc_end6-Santa_action1
	.cfi_endproc
                                        # -- End function
	.globl	Santa_action2           # -- Begin function Santa_action2
	.p2align	4, 0x90
	.type	Santa_action2,@function
Santa_action2:                          # @Santa_action2
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 16], 3
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end7:
	.size	Santa_action2, .Lfunc_end7-Santa_action2
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
