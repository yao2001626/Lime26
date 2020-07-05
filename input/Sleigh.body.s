	.text
	.intel_syntax noprefix
	.file	"Sleigh.c"
	.globl	Sleigh_back             # -- Begin function Sleigh_back
	.p2align	4, 0x90
	.type	Sleigh_back,@function
Sleigh_back:                            # @Sleigh_back
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 20]
	sub	eax, 1
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [edx + 20], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 20], 0
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	jne	.LBB0_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 6
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 20], 9
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Santa_back
.LBB0_2:
	add	esp, 28
	ret
.Lfunc_end0:
	.size	Sleigh_back, .Lfunc_end0-Sleigh_back
	.cfi_endproc
                                        # -- End function
	.globl	Sleigh_harness          # -- Begin function Sleigh_harness
	.p2align	4, 0x90
	.type	Sleigh_harness,@function
Sleigh_harness:                         # @Sleigh_harness
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 20]
	sub	eax, 1
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [edx + 20], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 20], 0
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	jne	.LBB1_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 7
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 20], 9
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Santa_harness
.LBB1_2:
	add	esp, 28
	ret
.Lfunc_end1:
	.size	Sleigh_harness, .Lfunc_end1-Sleigh_harness
	.cfi_endproc
                                        # -- End function
	.globl	Sleigh_pull             # -- Begin function Sleigh_pull
	.p2align	4, 0x90
	.type	Sleigh_pull,@function
Sleigh_pull:                            # @Sleigh_pull
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 20]
	sub	eax, 1
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [edx + 20], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 20], 0
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	jne	.LBB2_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 5
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 20], 9
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Santa_pull
.LBB2_2:
	add	esp, 28
	ret
.Lfunc_end2:
	.size	Sleigh_pull, .Lfunc_end2-Sleigh_pull
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
